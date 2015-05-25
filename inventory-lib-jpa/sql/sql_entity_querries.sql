CREATE TABLE addresses
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  createdAt DATETIME,
  deletedAt DATETIME,
  country VARCHAR(255),
  number VARCHAR(255),
  postCode VARCHAR(255),
  state VARCHAR(255),
  street VARCHAR(255),
  town VARCHAR(255),
  organization_id INT
);


CREATE TABLE inventory_user_login_history
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  createdAt DATETIME,
  deletedAt DATETIME,
  ip VARCHAR(255),
  loginAt DATETIME,
  userAgent VARCHAR(255),
  xForwardedFor VARCHAR(255),
  inventoryUser_id INT
);

CREATE TABLE inventory_users
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  createdAt DATETIME,
  deletedAt DATETIME,
  emailAddress VARCHAR(255),
  firstName VARCHAR(255),
  lastActivityAt DATETIME,
  lastName VARCHAR(255),
  mobilePhoneNumber VARCHAR(255),
  password VARCHAR(255),
  telephoneNumber VARCHAR(255),
  userRole VARCHAR(255),
  userUUId VARCHAR(255),
  organization_id INT

);

CREATE TABLE items
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  createdAt DATETIME,
  deletedAt DATETIME,
  addNewQuantity INT NOT NULL,
  barcodeNumber VARCHAR(255),
  discountPercentage DOUBLE NOT NULL,
  itemCategory VARCHAR(255),
  itemCost DOUBLE NOT NULL,
  itemImageId VARCHAR(255),
  itemName VARCHAR(255),
  quantityInStock INT NOT NULL,
  organization_id INT

);


CREATE TABLE organizations
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  createdAt DATETIME,
  deletedAt DATETIME,
  accountStatus VARCHAR(255),
  accountType VARCHAR(255),
  organizationName VARCHAR(255),
  organizationUUId VARCHAR(255),
  telephoneNumber VARCHAR(255),
  validityFrom DATETIME,
  validityTo DATETIME
);
