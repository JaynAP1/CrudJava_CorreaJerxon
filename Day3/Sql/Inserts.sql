INSERT INTO Concierto (id, nombre, artista, fecha, lugar, precioBase) VALUES
(1, 'Rock Fest', 'The Rock Band', '2023-12-15', 'Estadio Nacional', 50.00),
(2, 'Pop Night', 'The Pop Star', '2023-11-20', 'Arena Ciudad', 60.00),
(3, 'Jazz Night', 'The Jazz Group', '2023-10-25', 'Teatro Municipal', 40.00),
(4, 'Classic Night', 'The Symphony Orchestra', '2023-09-30', 'Auditorio Nacional', 70.00),
(5, 'Indie Fest', 'The Indie Band', '2023-08-15', 'Plaza de Toros', 30.00),
(6, 'Electronic Night', 'The DJ Collective', '2023-07-10', 'Club Nocturno', 50.00),
(7, 'Country Night', 'The Country Band', '2023-06-05', 'Salón Country', 45.00),
(8, 'Reggae Fest', 'The Reggae Band', '2023-05-01', 'Playa del Sol', 35.00),
(9, 'Hip Hop Night', 'The Hip Hop Group', '2023-04-15', 'Teatro Urbano', 55.00),
(10, 'Metal Fest', 'The Metal Band', '2023-03-10', 'Estadio Rock', 65.00);

INSERT INTO Zona (id, id_seleccion, id_concierto, nombreZona, capacidad, precioAdicional) VALUES
(1,1,1, 'General', 1000, 0.00),
(2,2,1, 'VIP', 200, 20.00),
(3,1,2, 'General', 100, 50.00),
(4,2,2, 'VIP', 500, 10.00),
(5,1,3, 'General', 50, 100.00),
(6,2,3, 'VIP', 300, 30.00),
(7,1,4, 'General', 300, 15.00),
(8,2,4, 'VIP', 800, 5.00),
(9,1,5, 'General', 2000, 0.00),
(10,2,5, 'VIP', 400, 25.00),
(11,1,6, 'General', 1000, 0.00),
(12,2,6, 'VIP', 200, 20.00),
(13,1,7, 'General', 100, 50.00),
(14,2,7, 'VIP', 500, 10.00),
(15,1,8, 'General', 50, 100.00),
(16,2,8, 'VIP', 300, 30.00),
(17,1,9, 'General', 300, 15.00),
(18,2,9, 'VIP', 800, 5.00),
(19,1,10, 'General', 2000, 0.00),
(20,2,10, 'VIP', 400, 25.00);
