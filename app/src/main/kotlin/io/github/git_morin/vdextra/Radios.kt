package io.github.git_morin.vdextra

/**
 * An online radio offering several stations. The station's stream URL is what gets saved as the
 * music path, so the module side needs no notion of radios: it just streams the URL.
 */
internal class Radio(
    val name: String,
    val labelRes: Int,
    val stations: List<Pair<String, String>>,
) {
    fun indexOf(url: String?): Int = stations.indexOfFirst { it.second == url }

    fun label(index: Int): String = "$name · ${stations[index].first}"
}

internal object Radios {

    val NIGHTRIDE = Radio(
        "Nightride FM",
        R.string.music_source_nightride,
        listOf(
            "Nightride" to "nightride",
            "Chillsynth" to "chillsynth",
            "Datawave" to "datawave",
            "Spacesynth" to "spacesynth",
            "Darksynth" to "darksynth",
            "Horrorsynth" to "horrorsynth",
            "EBSM" to "ebsm",
            "Rekt" to "rekt",
            "Rektory" to "rektory",
        ).map { (name, id) -> name to "https://stream.nightride.fm/$id.mp3" },
    )

    // The rainwave.cc/tune_in links serve an M3U playlist, which the player cannot open; the
    // relay serves the MP3 stream itself.
    val RAINWAVE = Radio(
        "Rainwave",
        R.string.music_source_rainwave,
        listOf(
            "Game" to "game",
            "OC ReMix" to "ocremix",
            "Covers" to "covers",
            "Chiptune" to "chiptune",
            "All" to "all",
        ).map { (name, id) -> name to "https://relay.rainwave.cc/$id.mp3" },
    )

    val ALL = listOf(NIGHTRIDE, RAINWAVE)

    fun stationLabel(url: String?): String? {
        for (radio in ALL) {
            val i = radio.indexOf(url)
            if (i >= 0) return radio.label(i)
        }
        return null
    }
}
