-- Insertar usuarios de prueba (contraseña: 123456)
INSERT INTO usuarios (nombre, correo_electronico, contrasena) VALUES
('Juan Pérez', 'juan@email.com', '$2a$10$N7.rEY8dGzmGkJsL8A6s8.pDhx1Y9Ggp5V8YvGmvNgxHvJ9vT7L0K'),
('María García', 'maria@email.com', '$2a$10$N7.rEY8dGzmGkJsL8A6s8.pDhx1Y9Ggp5V8YvGmvNgxHvJ9vT7L0K'),
('Pedro López', 'pedro@email.com', '$2a$10$N7.rEY8dGzmGkJsL8A6s8.pDhx1Y9Ggp5V8YvGmvNgxHvJ9vT7L0K');

-- Insertar cursos de prueba
INSERT INTO cursos (nombre, categoria) VALUES
('Spring Boot', 'Backend'),
('React', 'Frontend'),
('Java Básico', 'Backend'),
('JavaScript', 'Frontend'),
('Python', 'Backend');

-- Insertar algunos tópicos de prueba
INSERT INTO topicos (titulo, mensaje, fecha_creacion, status, autor_id, curso_id) VALUES
('¿Cómo configurar Spring Security?', 'Tengo problemas para configurar la autenticación en Spring Boot', NOW(), 'ABIERTO', 1, 1),
('Error con useState en React', 'Mi componente no se actualiza correctamente cuando uso useState', NOW(), 'ABIERTO', 2, 2),
('Diferencia entre JPA e Hibernate', '¿Cuál es la diferencia principal entre JPA e Hibernate?', NOW(), 'RESUELTO', 3, 1);