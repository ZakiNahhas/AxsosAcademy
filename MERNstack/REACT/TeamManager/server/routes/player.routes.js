const PlayerController = require("../controllers/player.controller");

module.exports = app => {
    app.get("/api/players/", PlayerController.findAllPlayers);
    app.post('/api/player/new', PlayerController.createPlayer)
    app.get("/api/player/:id", PlayerController.findOneSinglePlayer);
    app.put("/api/player/update/:id", PlayerController.updateExistingPlayer);
    app.delete("/api/player/:id", PlayerController.deleteAnExistingPlayer);

};