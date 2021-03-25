import React from "react";

interface Props {
  children: string;
}

const BookTitle = ({children}: Props) => (
  <div className="title" style={{
    fontSize: '2em',
    fontWeight: 'bold',
  }}>
    {children}
  </div>
);

export default BookTitle;