INSERT INTO USERS (ID, EMAIL, NAME, PASSWORD)
VALUES (0, 'admin_1@gmail.com', 'Admin_1', '$2a$10$DFPSRcZXm/wS/9ZYIU5oOey1vaCyI7r6bDk7yDgvNpLnho1LiFlf6'),
       (1, 'user_1@gmail.com', 'User_1', '$2a$10$ipKf6JCr8mXGbzDP9r2MwO8GV25tCSH3PQuu37CvWkSKCWJJw.XN2'),
       (2, 'user_2@gmail.com', 'User_2', '$2a$10$ipKf6JCr8mXGbzDP9r2MwO8GV25tCSH3PQuu37CvWkSKCWJJw.XN2');

INSERT INTO USER_ROLES (ROLE, USER_ID)
VALUES ('ROLE_ADMIN', 0),
       ('ROLE_USER', 1),
       ('ROLE_USER', 2);


INSERT INTO RESTAURANT (ID, NAME)
VALUES (0, 'Вино&Вода'),
       (1, 'Корюшка'),
       (2, 'Hooters'),
       (3, 'Хочу Харчо');

INSERT INTO LUNCH (ID, NAME, PRICE, RESTAURANT_ID)
VALUES (0, 'Жаркое', 300, 0),
       (1, 'Котлета по-киевски', 250, 0),
       (2, 'Суп', 150, 1),
       (3, 'Пюре', 250, 1),
       (4, 'Харчо', 200, 2),
       (5, 'Яичница', 250, 2),
       (6, 'Фуагра', 300, 3),
       (7, 'Индейка', 250, 3);