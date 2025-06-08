from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from typing import List, Optional

app = FastAPI()

class Book(BaseModel):
    id: Optional[int] = None
    title: str
    author: str

books_db = []
book_id_counter = 1

@app.get("/health")
def health():
    return {"status": "ok"}

@app.post("/books/", status_code=201)
def create_book(book: Book):
    global book_id_counter
    book.id = book_id_counter
    book_id_counter += 1
    books_db.append(book)
    return book

@app.get("/books/", response_model=List[Book])
def list_books():
    return books_db

@app.put("/books/{book_id}")
def update_book(book_id: int, updated_book: Book):
    for idx, b in enumerate(books_db):
        if b.id == book_id:
            updated_book.id = book_id
            books_db[idx] = updated_book
            return updated_book
    raise HTTPException(status_code=404, detail="Book not found")

@app.delete("/books/{book_id}", status_code=204)
def delete_book(book_id: int):
    global books_db
    books_db = [b for b in books_db if b.id != book_id]
    return {}
