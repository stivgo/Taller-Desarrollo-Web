# Taller-Desarrollo-Web
Taller 1 Desarrollo Web Java Spring

Nombres: Stiven Gonzalez & John Gonzalez

# Ejemplos de Ejecución

Punto 1:

Verbo: GET

Path: /libros 

Body:
{
    "id": 7,
    "titulo": "Otro Libro",
    "descripcion": "Un libro de prueba",
    "precio": 100000,
    "nombreAutor": "Mario",
    "apellidoAutor": "Mendoza",
    "year": 2020
}

Punto 2:

Verbo: GET

Path: /libros/autor?nombreAutor={nombre buscado}&apellidoAutor={apellido buscado}

Ejemplo Path: /libros/autor?nombreAutor=gabriel&apellidoAutor=garcia

Punto 3:

Verbo PUT

Path: /libros/detalle/{id del libro}

Ejemplo Path: /libros/detalle/2

Body:
{
    "numeroPaginas" : 50
}
