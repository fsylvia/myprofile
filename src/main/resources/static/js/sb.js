/*    // JSON data
   var nodeData = {"name":"Skills","children":[
	{"name":"Language","children":[
		{"name":"Java","size":84.0},
		{"name":"Client-Side Javascript","size":86.0},
		{"name":"SQL","size":86.0},
		{"name":"PHP","size":13.0},
		{"name":"Html","size":23.0},
		{"name":"Css","size":23.0},
		{"name":"ASP","size":10.0}
	]},
	{"name":"Library","children":[
		{"name":"Junit","size":84.0},
		{"name":"XPath","size":21.0},
		{"name":"Jackson","size":21.0},
		{"name":"JaxRS","size":21.0},
		{"name":"JSP","size":43.0},
		{"name":"Hibernate","size":63.0},
		{"name":"JAXB","size":17.0},
		{"name":"JQuery","size":17.0},
		{"name":"Ajax","size":37.0},
		{"name":"Tapestry","size":20.0},
		{"name":"Freemarker","size":20.0},
		{"name":"Apache Axis","size":46.0},
		{"name":"Cactus","size":26.0},
		{"name":"StrutsTestCase","size":26.0},
		{"name":"JMock","size":26.0}]
	},
	{"name":"Tool","children":[
		{"name":"CI","children":[
			{"name":"CodePro","size":21.0},
			{"name":"Sonarqube","size":38.0},
			{"name":"Checkstyle","size":63.0},
			{"name":"PMD","size":63.0},
			{"name":"Cobertura","size":46.0}
		]},
		{"name":"Build","children":[
			{"name":"Script","children":[
				{"name":"Maven","size":38.0},
				{"name":"ANT","size":46.0}
			]},
			{"name":"CD","children":[
				{"name":"Jenkins","size":17.0},
				{"name":"CruiseControl","size":26.0}
			]}
		]}
	]},
	{"name":"Server","children":[
		{"name":"Jboss","size":43.0},
		{"name":"Tomcat","size":20.0},
		{"name":"Apache Http Server","size":13.0},
		{"name":"IIS","size":10.0}
	]},
	{"name":"IDE","children":[
		{"name":"Eclipse","size":84.0}
	]},
	{"name":"Framework","children":[
		{"name":"Spring","size":37.0},
		{"name":"Struts 1.2.7","size":26.0}
	]},
	{"name":"Database","children":[
		{"name":"Rdbms","children":[
			{"name":"MS Sql Server","size":86.0}
		]}
	]}
]}*/


    
	var nodeData = skillJson;
    // Variables
    var width = 500;
    var height = 500;
    var radius = Math.min(width, height) / 2;
    var color = d3.scaleOrdinal(d3.schemeCategory20b);

    // Create primary <g> element
    var g = d3.select('svg')
        .attr('width', width)
        .attr('height', height)
        .append('g')
        .attr('transform', 'translate(' + width / 2 + ',' + height / 2 + ')');

    // Data strucure
    var partition = d3.partition()
        .size([2 * Math.PI, radius]);

    // Find data root
    var root = d3.hierarchy(nodeData)
        .sum(function (d) { return d.size});

    // Size arcs
    partition(root);
    var arc = d3.arc()
        .startAngle(function (d) { return d.x0 })
        .endAngle(function (d) { return d.x1 })
        .innerRadius(function (d) { return d.y0 })
        .outerRadius(function (d) { return d.y1 });

    // Put it all together
    g.selectAll('g')
        .data(root.descendants())
        .enter().append('g').attr("class","node")
        .append('path')
        .attr("display", function (d) { return d.depth ? null : "none"; })
        .attr("d", arc)
        .style("fill", function(d){return color(getRootmostAncestor(d).data.name)})

    // Populate the <text> elements with our data-driven titles.
    g.selectAll(".node")
        .append("text")
        .attr("transform", function(d) {
            return "translate(" + arc.centroid(d) + ")rotate(" + computeTextRotation(d) + ")"; })
        .attr("dx", "-20") // radius margin
        .attr("dy", ".5em") // rotation align
        .attr('font-size', '.6em')
        .text(function(d) { return d.parent ? d.data.name : "" });
    
    /**
     * Calculate the correct distance to rotate each label based on its location in the sunburst.
     * @param {Node} d
     * @return {Number}
     */
    function computeTextRotation(d) {
        var angle = (d.x0 + d.x1) / Math.PI * 90;

        // Avoid upside-down labels
        //return (angle < 120 || angle > 270) ? angle : angle + 180;  // labels as rims
        return (angle < 180) ? angle - 90 : angle + 90;  // labels as spokes
    }
    
    function getRootmostAncestor(node) {
        while (node.depth > 1) node = node.parent;
        return node;
    }