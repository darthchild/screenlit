-- V1__insert_initial_reviews.sql for populating initial review data into the review table
-- Add rating column to review table
ALTER TABLE review ADD COLUMN rating NUMERIC(3,1) CHECK (rating >= 0 AND rating <= 10);

-- Populate reviews table with varied reviews and ratings for specified movies

INSERT INTO review (body, movie_id, rating) VALUES
-- Puss in Boots: The Last Wish
('Swashbuckling fun with heart and humor!', 1, 8.5),
('Visually stunning, but plot feels recycled.', 1, 7.2),
('Entertaining sequel that surpasses expectations.', 1, 8.0),

-- Avatar: The Way of Water
('Breathtaking visuals, somewhat thin plot.', 2, 7.8),
('Cameron pushes technological boundaries once again!', 2, 9.0),
('Immersive experience, but drags in the middle.', 2, 7.5),

-- M3GAN
('Unsettling and surprisingly witty.', 3, 7.7),
('Fresh take on the otherwise repetitive killer doll trope.', 3, 8.2),
('Mediocre script saved by the horrifying creepy effects.', 3, 6.5),

-- Troll
('A quite surprisingly charming Norwegian folklore tale.', 4, 7.0),
('Decent effects, but predictable storyline.', 4, 6.3),
('Family-friendly monster movie with a surprisingly local flair.', 4, 7.5),

-- Black Adam
('Dwayne Johnson\'s charisma elevates the otherwise formulaic plot.', 5, 6.8),
('Spectacular action, underdeveloped characters!', 5, 7.0),
('Refreshing anti-hero perspective, if a bit blunt maybe', 5, 7.3),

-- Avatar
('Revolutionary visuals, familiar storyline.', 6, 8.7),
('Immersive world-building at its finest.', 6, 9.5),
('Technologically groundbreaking, narratively safe.', 6, 8.0),

-- Roald Dahl's Matilda the Musical
('A Whimsical adaptation with catchy tunes.', 7, 8.3),
('Thompson shines as Trunchbull but suffers with pacing issues.', 7, 7.6),
('Really captures the book\'s spirit beautifully.', 7, 8.8),

-- Black Panther: Wakanda Forever
('Poignant tribute wrapped in superhero spectacle.', 8, 8.5),
('Emotionally resonant, but overstuffed plot.', 8, 7.8),
('Stellar performances elevate familiar Marvel formula.', 8, 8.2),

-- Strange World
('Vibrant animation, muddled environmental message.', 9, 6.7),
('Creative world design, forgettable characters.', 9, 6.5),
('Ambitious themes, but lacks Disney magic.', 9, 7.0),

-- The Woman King
('Davis commands the screen in a quite fierce epic.', 10, 8.7),
('Thrilling action sequences, but occasionally slow pacing.', 10, 7.9),
('Powerful performances in a conventional historical drama.', 10, 8.3);