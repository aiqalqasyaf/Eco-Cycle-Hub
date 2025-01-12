-- Create Users table
CREATE TABLE USERS (
    UserID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    PhoneNo VARCHAR(15) NOT NULL,
    Address VARCHAR(255)
);

-- Create Bike table
CREATE TABLE BIKE (
    BikeID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Model VARCHAR(100) NOT NULL,
    UserID INT DEFAULT NULL, -- NULL if the bike belongs to the rental system
    Color VARCHAR(50),
    RegistrationDate DATE NOT NULL,
    Status VARCHAR(50) DEFAULT 'Available',
    OwnershipType VARCHAR(50) NOT NULL CHECK (OwnershipType IN ('User', 'RentalSystem')), -- New attribute
    FOREIGN KEY (UserID) REFERENCES USERS(UserID) ON DELETE CASCADE
);

-- Create Slot table
CREATE TABLE SLOT (
    SlotID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Location VARCHAR(100) NOT NULL,
    BikeID INT DEFAULT NULL,
    IsOccupied BOOLEAN DEFAULT FALSE,
    RegistrationDate DATE NOT NULL,
    FOREIGN KEY (BikeID) REFERENCES BIKE(BikeID) ON DELETE SET NULL
);

-- Create Admin table
CREATE TABLE ADMIN (
    AdminID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL
);

-- Create Transactions table
CREATE TABLE TRANSACTIONS (
    TransactionID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Status VARCHAR(50) NOT NULL,
    SlotID INT NOT NULL,
    BikeID INT NOT NULL,
    UserID INT NOT NULL,
    AdminID INT NOT NULL,
    StartTime TIMESTAMP NOT NULL,
    EndTime TIMESTAMP DEFAULT NULL,
    FOREIGN KEY (SlotID) REFERENCES SLOT(SlotID) ON DELETE CASCADE,
    FOREIGN KEY (BikeID) REFERENCES BIKE(BikeID) ON DELETE CASCADE,
    FOREIGN KEY (UserID) REFERENCES USERS(UserID) ON DELETE CASCADE,
    FOREIGN KEY (AdminID) REFERENCES ADMIN(AdminID) ON DELETE CASCADE
);

-- Create RentBike table
CREATE TABLE RENTBIKE (
    RentID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    UserID INT NOT NULL,
    BikeID INT NOT NULL,
    DurationTime INT NOT NULL, -- Duration in minutes
    Status VARCHAR(50) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES USERS(UserID) ON DELETE CASCADE,
    FOREIGN KEY (BikeID) REFERENCES BIKE(BikeID) ON DELETE CASCADE
);

-- Example data (optional)
INSERT INTO ADMIN (Name, Email, Password) VALUES ('Admin2', 'admin1@example.com', 'password123');
INSERT INTO USERS (Name, Password, Email, PhoneNo, Address) VALUES ('User1', 'user1', 'user1@example.com', '1234567890', '123 Main St');
INSERT INTO BIKE (Model, UserID, Color, RegistrationDate, Status, OwnershipType) VALUES ('ModelX', 1, 'Red', '2025-01-01', 'Available', 'User');
INSERT INTO SLOT (Location, RegistrationDate, IsOccupied) VALUES ('Slot A', '2025-01-01', FALSE);
