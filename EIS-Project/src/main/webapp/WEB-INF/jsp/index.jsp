<!DOCTYPE html>
<meta charset="utf-8">
<style>

body {
  background: #fcfcfa;
}

.stroke {
  fill: none;
  stroke: #000;
  stroke-width: 3px;
}

.fill {
  fill: #fff;
}

.graticule {
  fill: none;
  stroke: #777;
  stroke-width: .5px;
  stroke-opacity: .5;
}

.land {
  fill: #222;
}

.boundary {
  fill: none;
  stroke: #fff;
  stroke-width: .5px;
}

</style>
<body>
<script src="http://d3js.org/d3.v3.min.js"></script>
<script src="http://d3js.org/d3.geo.projection.v0.min.js"></script>
<script src="http://d3js.org/topojson.v1.min.js"></script>

<script>

var width = 1100,
    height = 700;

var projection = d3.geo.eckert4()
    .scale(200)
    .translate([width / 2, height / 2])
    .precision(.1);

var path = d3.geo.path()
    .projection(projection);

var graticule = d3.geo.graticule();

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height);

svg.append("defs").append("path")
    .datum({type: "Sphere"})
    .attr("id", "sphere")
    .attr("d", path);

svg.append("use")
    .attr("class", "stroke")
    .attr("xlink:href", "#sphere");

svg.append("use")
    .attr("class", "fill")
    .attr("xlink:href", "#sphere");

svg.append("path")
    .datum(graticule)
    .attr("class", "graticule")
    .attr("d", path);

d3.json("<%=request.getContextPath()%>/resources/world-50m.json", function(error, world) {
  svg.insert("path", ".graticule")
      .datum(topojson.feature(world, world.objects.land))
      .attr("class", "land")
      .attr("d", path);

  svg.insert("path", ".graticule")
      .datum(topojson.mesh(world, world.objects.countries, function(a, b) { return a !== b; }))
      .attr("class", "boundary")
      .attr("d", path);
});

quake();

function quake() {
	svg.append("circle")
	.attr("cx", 300)
	.attr("cy", 300)
	.style("fill", "red")
	.style("fill-opacity", 0.5)
	.style("stroke", "red")
	.style("stroke-opacity", 0.5)
	.transition()
	   .duration(2000)
	   .ease(Math.sqrt)
	   .attr("r", 10)
	   .style("fill-opacity", 1e-6)
	   .style("stroke-opacity", 1e-6)
	   .remove()
	setTimeout(quake, 2000);
}

d3.select(self.frameElement).style("height", height + "px");


</script>