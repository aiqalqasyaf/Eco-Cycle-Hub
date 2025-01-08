-- Create User table
CREATE TABLE "User" (
    UserID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    PhoneNo VARCHAR(15) NOT NULL,
    Address VARCHAR(255)
);

-- Create Bike table
CREATE TABLE Bike (
    BikeID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Model VARCHAR(100) NOT NULL,
    UserID INT DEFAULT NULL, -- NULL if the bike belongs to the rental system
    Color VARCHAR(50),
    RegistrationDate DATE NOT NULL,
    Status VARCHAR(50) DEFAULT 'Available',
    OwnershipType VARCHAR(50) NOT NULL CHECK (OwnershipType IN ('User', 'RentalSystem')), -- New attribute
    FOREIGN KEY (UserID) REFERENCES "User"(UserID) ON DELETE CASCADE
);

-- Create Slot table
CREATE TABLE Slot (
    SlotID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Location VARCHAR(100) NOT NULL,
    BikeID INT DEFAULT NULL,
    IsOccupied BOOLEAN DEFAULT FALSE,
    RegistrationDate DATE NOT NULL,
    FOREIGN KEY (BikeID) REFERENCES Bike(BikeID) ON DELETE SET NULL
);

-- Create Admin table
CREATE TABLE Admin (
    AdminID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL
);

-- Create Transaction table
CREATE TABLE "Transaction" (
    TransactionID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Status VARCHAR(50) NOT NULL,
    SlotID INT NOT NULL,
    BikeID INT NOT NULL,
    UserID INT NOT NULL,
    AdminID INT NOT NULL,
    StartTime TIMESTAMP NOT NULL,
    EndTime TIMESTAMP DEFAULT NULL,
    FOREIGN KEY (SlotID) REFERENCES Slot(SlotID) ON DELETE CASCADE,
    FOREIGN KEY (BikeID) REFERENCES Bike(BikeID) ON DELETE CASCADE,
    FOREIGN KEY (UserID) REFERENCES "User"(UserID) ON DELETE CASCADE,
    FOREIGN KEY (AdminID) REFERENCES Admin(AdminID) ON DELETE CASCADE
);

-- Create RentBike table
CREATE TABLE RentBike (
    RentID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    UserID INT NOT NULL,
    BikeID INT NOT NULL,
    DurationTime INT NOT NULL, -- Duration in minutes
    Status VARCHAR(50) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES "User"(UserID) ON DELETE CASCADE,
    FOREIGN KEY (BikeID) REFERENCES Bike(BikeID) ON DELETE CASCADE
);

-- Ensure StartTime < EndTime in Transaction table
-- Derby does not support CHECK constraints for this logic. It must be enforced in application logic.

-- Example data (optional)
INSERT INTO Admin (Name, Email, Password) VALUES ('Admin2', 'admin1@example.com', 'password123');
INSERT INTO "User" (Name, Email, PhoneNo, Address) VALUES ('User1', 'user1@example.com', '1234567890', '123 Main St');
INSERT INTO Bike (Model, UserID, Color, RegistrationDate, Status, OwnershipType) VALUES ('ModelX', 1, 'Red', '2025-01-01', 'Available', 'User' );
INSERT INTO Slot (Location, RegistrationDate, IsOccupied) VALUES ('Slot A', '2025-01-01', FALSE);
