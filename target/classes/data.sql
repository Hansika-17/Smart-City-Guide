-- Tourist Places
INSERT INTO tourist_places (place_name, city, address, description, image_url, timings, category)
VALUES
('Charminar', 'Hyderabad', 'Old City', 'Historic Monument', 'https://example.com/charminar.jpg', '9 AM - 6 PM', 'Monument'),
('Golconda Fort', 'Hyderabad', 'Golconda', 'Historic Fort', 'https://example.com/golconda.jpg', '9 AM - 5 PM', 'Fort');

-- Hospitals
INSERT INTO hospitals (hospital_name, city, address, contact_number, email, image_url)
VALUES
('Apollo Hospital', 'Hyderabad', 'Jubilee Hills', '9876543210', 'apollo@gmail.com', 'https://example.com/apollo.jpg'),
('Yashoda Hospital', 'Hyderabad', 'Somajiguda', '9876543211', 'yashoda@gmail.com', 'https://example.com/yashoda.jpg');

-- Police Stations
INSERT INTO police_stations (station_name, city, address, contact_number, email, image_url)
VALUES
('Banjara Hills Police Station', 'Hyderabad', 'Road No.12', '9876543212', 'police@gmail.com', 'https://example.com/police.jpg');

-- Fire Stations
INSERT INTO fire_stations (station_name, city, address, contact_number, email, image_url)
VALUES
('Hyderabad Fire Station', 'Hyderabad', 'Lakdikapul', '9876543213', 'fire@gmail.com', 'https://example.com/fire.jpg');

-- Pharmacies
INSERT INTO pharmacies (pharmacy_name, city, address, contact_number, email, image_url)
VALUES
('Apollo Pharmacy', 'Hyderabad', 'Madhapur', '9876543214', 'pharmacy@gmail.com', 'https://example.com/pharmacy.jpg');

-- Emergency Contacts
INSERT INTO emergency_contacts (service_name, city, phone_number, description)
VALUES
('Police', 'Hyderabad', '100', 'Police Emergency'),
('Fire', 'Hyderabad', '101', 'Fire Emergency'),
('Ambulance', 'Hyderabad', '108', 'Medical Emergency'),
('Women Helpline', 'Hyderabad', '1091', 'Women Safety');