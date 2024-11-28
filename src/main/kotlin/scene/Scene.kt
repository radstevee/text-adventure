package net.radstevee.textadventure.scene

interface Scene {
    var parent: Scene?

    fun display(playerName: String)

    fun startSubScene(playerName: String, scene: Scene) {
        scene.parent = this
        scene.display(playerName)
    }
}
