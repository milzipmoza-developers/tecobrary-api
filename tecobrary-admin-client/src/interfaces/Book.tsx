export interface Book {
  bookSerial: string;
  bookStatus: string;
  rentMember?: string;
  rentDateTime?: string;
}

export interface BookEnrollRequest extends SerialNumber {
  serialNumber: string;
}

export interface SerialNumber {
  serialNumber: string;
}