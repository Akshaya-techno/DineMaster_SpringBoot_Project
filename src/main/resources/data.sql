INSERT INTO restaurant (id, name, address, cuisineType, rating) VALUES
(1, 'Fine Dining', '123 Main St', 'European', 5),
(2, 'Taco Bell', '456 Elm St', 'Fast Food', 3),
(3, 'Sushi Place', '789 Oak St', 'Japanese', 4);

INSERT INTO chef (firstName, lastName, expertise, experienceYears, restaurantId) VALUES
('John', 'Doe', 'Sous Chef', 5, 1),
('Jane', 'Doe', 'Pastry Chef', 7, 1),
('Mike', 'Smith', 'Head Chef', 10, 2),
('Emily', 'Johnson', 'Sushi Chef', 8, 3),
('Anna', 'Williams', 'Pastry Chef', 6, 3),
('Mark', 'Brown', 'Sous Chef', 4, 2);