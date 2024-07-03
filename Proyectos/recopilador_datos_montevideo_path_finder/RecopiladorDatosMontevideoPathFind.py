import osmnx as ox

place_name = "Montevideo, Uruguay"
G = ox.graph_from_place(place_name, network_type="drive")

for edge in G.edges:
    # Cleaning the "maxspeed" attribute, some values are lists, some are strings, some are None
    maxspeed = 40
    if "maxspeed" in G.edges[edge]:
        maxspeed = G.edges[edge]["maxspeed"]
        if type(maxspeed) == list:
            speeds = [ int(speed) for speed in maxspeed ]
            maxspeed = min(speeds)
        elif type(maxspeed) == str:
            maxspeed = int(maxspeed)
    G.edges[edge]["maxspeed"] = maxspeed
    # Adding the "weight" attribute (time = distance / speed)
    G.edges[edge]["weight"] = G.edges[edge]["length"] / maxspeed

# Escribir los vértices en un archivo
with open("Vertices.txt", "w") as vertices_file:
    for node in G.nodes:
        vertices_file.write(f"{node}\n")

# Escribir las aristas en un archivo
with open("Aristas.txt", "w") as aristas_file:
    for edge in G.edges:
        vertice1, vertice2 = edge[:2]
        costoArista = G.edges[edge]["weight"]
        aristas_file.write(f"{vertice1}, {vertice2}, {costoArista}\n")
