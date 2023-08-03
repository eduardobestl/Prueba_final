create database gestion;
use gestion;

CREATE TABLE Mesa (
  ID INT PRIMARY KEY,
  Numero INT,
  Capacidad INT,
  Ubicacion VARCHAR(255)
);
CREATE TABLE Camarero (
  ID INT PRIMARY KEY,
  Nombre VARCHAR(255),
  Edad INT,
  Fecha_Inicio DATE
);

CREATE TABLE Plato (
  ID INT PRIMARY KEY,
  Nombre VARCHAR(255),
  Descripcion VARCHAR(255),
  Precio DECIMAL(5,2),
  Categoria VARCHAR(255)
);

CREATE TABLE Pedido (
  ID INT PRIMARY KEY,
  Mesa_ID INT,
  Camarero_ID INT,
  Fecha DATE,
  Total DECIMAL(5,2),
  FOREIGN KEY (Mesa_ID) REFERENCES Mesa(ID),
  FOREIGN KEY (Camarero_ID) REFERENCES Camarero(ID)
);

CREATE TABLE Detalle_Pedido (
  Pedido_ID INT,
  Plato_ID INT,
  Cantidad INT,
  Subtotal DECIMAL(5,2),
  PRIMARY KEY (Pedido_ID, Plato_ID),
  FOREIGN KEY (Pedido_ID) REFERENCES Pedido(ID),
  FOREIGN KEY (Plato_ID) REFERENCES Plato(ID)
);

-- Insertar mesas
INSERT INTO Mesa VALUES (1, 1, 4, 'Interior');
INSERT INTO Mesa VALUES (2, 2, 2, 'Interior');
INSERT INTO Mesa VALUES (3, 3, 6, 'Exterior');
INSERT INTO Mesa VALUES (4, 4, 2, 'Exterior');
INSERT INTO Mesa VALUES (5, 5, 4, 'Interior');

-- Insertar camareros
INSERT INTO Camarero VALUES (1, 'Juan', 25, '2022-01-01');
INSERT INTO Camarero VALUES (2, 'Ana', 30, '2020-06-01');
INSERT INTO Camarero VALUES (3, 'Pedro', 22, '2023-05-01');
INSERT INTO Camarero VALUES (4, 'Sofia', 27, '2021-02-01');
INSERT INTO Camarero VALUES (5, 'Luis', 32, '2019-08-01');

-- Insertar platos
INSERT INTO Plato VALUES (1, 'Ensalada César', 'Lechuga, pollo, queso parmesano, aderezo césar', 7.50, 'Entrada');
INSERT INTO Plato VALUES (2, 'Burger Clásica', 'Carne de res, queso, lechuga, tomate', 10.00, 'Plato principal');
INSERT INTO Plato VALUES (3, 'Tarta de manzana', 'Tarta de manzana con una bola de helado de vainilla', 5.00, 'Postre');
INSERT INTO Plato VALUES (4, 'Sopa de tomate', 'Sopa de tomate con albahaca y croutons', 6.00, 'Entrada');
INSERT INTO Plato VALUES (5, 'Pasta carbonara', 'Spaghetti, huevo, queso parmesano, panceta', 9.00, 'Plato principal');

-- Insertar pedidos
INSERT INTO Pedido VALUES (1, 1, 1, '2023-07-01', 17.50);
INSERT INTO Pedido VALUES (2, 2, 2, '2023-07-02', 15.00);
INSERT INTO Pedido VALUES (3, 3, 3, '2023-07-03', 22.50);
INSERT INTO Pedido VALUES (4, 4, 4, '2023-07-04', 14.00);
INSERT INTO Pedido VALUES (5, 5, 5, '2023-07-05', 19.00);

-- Insertar detalles de los pedidos
INSERT INTO Detalle_Pedido VALUES (1, 1, 1, 7.50);
INSERT INTO Detalle_Pedido VALUES (1, 2, 1, 10.00);
INSERT INTO Detalle_Pedido VALUES (2, 4, 1, 6.00);
INSERT INTO Detalle_Pedido VALUES (2, 5, 1, 9.00);
INSERT INTO Detalle_Pedido VALUES (3, 1, 1, 7.50);
INSERT INTO Detalle_Pedido VALUES (3, 2, 1, 10.00);
INSERT INTO Detalle_Pedido VALUES (3, 3, 1, 5.00);
INSERT INTO Detalle_Pedido VALUES (4, 4, 1, 6.00);
INSERT INTO Detalle_Pedido VALUES (4, 5, 1, 9.00);
INSERT INTO Detalle_Pedido VALUES (5, 1, 1, 7.50);
INSERT INTO Detalle_Pedido VALUES (5, 5, 1, 9.00);
INSERT INTO Detalle_Pedido VALUES (5, 3, 1, 5.00);
------------------------------------------------------------
--Consulta 1
--Se solicita mostrar los nombres y cantidades solicitadas de los platos en el pedido de id 1.

se consulta con las siguientes querys

SELECT * FROM gestion.pedido;

con esto conseguimos el id el primer Id y consultamos nuevamente

SELECT * FROM gestion.detalle_pedido;

con esto obtenemos el ID de tanto como pedido y plato

y por ultimo

SELECT * FROM gestion.plato;

con esto obtenemos # ID, Nombre, Descripcion, Precio, Categoria
                   '1', 'Ensalada César', 'Lechuga, pollo, queso parmesano, aderezo césar', '7.50', 'Entrada'


el nombre y cantidad.

------------------------------------------------------------------------

--Consulta 2
--Se solicita una lista con la cantidad de pedidos que recibido cada mesa

para esta consulta se debe utilizar una combinacion entre las tablas mesa y pedidos

SELECT m.Numero AS NumeroMesa, COUNT(p.ID) AS CantidadPedidos
FROM Mesa m
LEFT JOIN Pedido p ON m.ID = p.Mesa_ID
GROUP BY m.Numero;

# NumeroMesa, CantidadPedidos
'1', '1'
'2', '1'
'3', '1'
'4', '1'
'5', '1'


se utiliza la función de agregación COUNT para contar la cantidad de pedidos que tiene cada mesa. La cláusula GROUP BY agrupa los resultados por el número de mesa.

-----------------------------------------------------------

--Consulta 3
--Se solicita una lista con el monto de ventas de cada camarero, ordenados alfabéticamente
--de forma descendente, agrupados por el nombre del camarero.

SELECT c.Nombre AS NombreCamarero, SUM(dp.Subtotal) AS MontoVentas
FROM Camarero c
LEFT JOIN Pedido p ON c.ID = p.Camarero_ID
LEFT JOIN Detalle_Pedido dp ON p.ID = dp.Pedido_ID
GROUP BY c.Nombre
ORDER BY MontoVentas DESC;

# NombreCamarero, MontoVentas
'Pedro', '22.50'
'Luis', '21.50'
'Juan', '17.50'
'Ana', '15.00'
'Sofia', '15.00'


en esta consulta se hace algo similar a lo anterior pero con 3 tablas y se utiliza la función de agregación SUM para calcular el monto total de ventas para cada camarero.

--------------------------------------------------
--Consulta 4
--Se solicita mostrar el plato más solicitado y la cantidad correspondiente de solicitudes.

SELECT p.Nombre AS PlatoMasSolicitado, COUNT(*) AS CantidadSolicitudes
FROM Plato p
INNER JOIN Detalle_Pedido dp ON p.ID = dp.Plato_ID
GROUP BY p.Nombre
ORDER BY CantidadSolicitudes DESC
LIMIT 1;

# ID, Nombre, Descripcion, Precio, Categoria
'1', 'Ensalada César', 'Lechuga, pollo, queso parmesano, aderezo césar', '7.50', 'Entrada'
'2', 'Burger Clásica', 'Carne de res, queso, lechuga, tomate', '10.00', 'Plato principal'
'3', 'Tarta de manzana', 'Tarta de manzana con una bola de helado de vainilla', '5.00', 'Postre'
'4', 'Sopa de tomate', 'Sopa de tomate con albahaca y croutons', '6.00', 'Entrada'
'5', 'Pasta carbonara', 'Spaghetti, huevo, queso parmesano, panceta', '9.00', 'Plato principal'


se utiliza una combinación interna (INNER JOIN) entre las tablas Plato y Detalle_Pedido para relacionar los platos con los detalles de los pedidos
y se usa COUNT para contabilizar la cantidad de solicitudes de platos,La cláusula GROUP BY agrupa los resultados por el nombre del plato y la cláusula ORDER BY los ordena de forma descendente según la cantidad de solicitudes. La cláusula LIMIT 1 se utiliza para mostrar solo el plato más solicitado

----------------------------------------------------------------------

--Consulta 5
--Se solicita una lista con los platos vendidos y el valor total que se ha obtenido por cada plato,
--agrupados por el nombre del plato y ordenados de forma ascendente.


SELECT p.Nombre AS PlatoVendido, SUM(dp.Subtotal) AS ValorTotalObtenido
FROM Plato p
INNER JOIN Detalle_Pedido dp ON p.ID = dp.Plato_ID
GROUP BY p.Nombre
ORDER BY ValorTotalObtenido ASC;

# PlatoVendido, ValorTotalObtenido
'Tarta de manzana', '10.00'
'Sopa de tomate', '12.00'
'Burger Clásica', '20.00'
'Ensalada César', '22.50'
'Pasta carbonara', '27.00'


en esta consulta tambien se hace una combinacion de tablas pero con INNER JOIN entre tabla de plato y detalle_pedido y de esa forma poder
relacionarlos .Tambien se utiliza la función de agregación SUM para sumar los subtotales de cada detalle de pedido y obtener así el valor total obtenido por cada plato
