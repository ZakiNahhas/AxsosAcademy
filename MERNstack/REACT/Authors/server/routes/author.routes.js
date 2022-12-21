const AuthorController = require("../controllers/author.controller");

module.exports = app => {
    app.get("/api/authors/", AuthorController.findAllAuthors);
    app.post('/api/author/new', AuthorController.createAuthor)
    app.get("/api/author/:id", AuthorController.findOneSingleAuthor);
    app.put("/api/author/update/:id", AuthorController.updateExistingAuthor);
    app.delete("/api/author/:id", AuthorController.deleteAnExistingAuthor);

};