<div align="center">
  <img width="160" height="160" alt="VDExtra app icon" src="https://raw.githubusercontent.com/git-morin/io.github.git_morin.vdextra/main/docs/icon.png" />
  <h1>VDExtra</h1>

  <a href="https://github.com/git-morin/io.github.git_morin.vdextra/releases/latest"><img alt="stable release" src="https://img.shields.io/github/v/release/git-morin/io.github.git_morin.vdextra?display_name=release&label=stable&color=blue"></a>
  <a href="https://github.com/git-morin/io.github.git_morin.vdextra"><img alt="source" src="https://img.shields.io/badge/source-git--morin%2Fvdextra-24292e?logo=github"></a>
</div>

Xposed module to add extra features to **Virtual Desktop** (VR).

> Does not circumvent the license requirement from the application. Please buy the software legitimately [here](https://www.vrdesktop.net/) !

⚠️ EARLY STAGE ⚠️

This project is in its early stages. Currently tested only on my own personal hardware:
- arm64-v8a (Quest 3)
- libxposed API 102
- Virtual Desktop 1.34.22 and 1.34.25

**The module may misbehave by either not changing anything in **VD** (failed to hook internals of the app) or by crashing VD at launch (which in the Quest translate to a long load and then a dialog about the app not responding).
If you meet these two situations then please [open an issue](https://github.com/git-morin/io.github.git_morin.vdextra/issues) with your hardware specifications and the **VD** version that you are running.**

## Features

- **Interface translation**: Translate **VD**'s UI in one of the currently supported languages. Do note that I am not polyglot, the current translations were made by using translation software.
  - Contributions to new languages are welcomed. Feel free to submit a merge request (see the [translation doc](https://github.com/git-morin/io.github.git_morin.vdextra/blob/main/docs/translations.md))
  - Resize of some elements for better fit in languages with more symbols.
- **Extend bitrate range**: Increase the allowed maximum bitrate between **VD** and the connected machine.
  - ⚠️ Make sure to stay within your bandwidth, you will get choppy performance if you push this beyond your network capacity.
- **Remove internal bitrate cap**: Prevent the measured bandwidth (internally from **VD**) from throttling what actually gets streamed.
  - ⚠️ Does not magically give you bandwidth. This is to prevent **VD** from meddling with the bitrate's current value when it does its own internal bandwidth check.
  - Generally you want this active if you use `Extend bitrate range`.
- **Custom background music**: Changes the song and volume of the music playing when **VD** isn't connected to a machine.
  - 🐱🌙 Connects to [Nightwave Plaza](https://plaza.one/) by default.
  - For your own song, you need the file locally in the device.
- **Disable performance cue sounds**: Mute the sounds that are played when you edit **VD**'s performance slider.
- **Force LAN discovery**: Find local PCs even when the remote server is unreachable (fixes some restrictive networks).

## In Virtual Desktop

Most of the module is configured from a **VDEXTRA** page in Virtual Desktop's own control panel.
Its rows are clones of VD's own controls, so they match the rest of the interface, and they are
translated along with everything else. A change takes effect straight away and survives a restart.

![The VDExtra page in Virtual Desktop's control panel, beside the companion app](https://raw.githubusercontent.com/git-morin/io.github.git_morin.vdextra/main/docs/vdextra-section.jpg)

Settings that need Android to do the work stay in the companion app: the music source, the UI
language, the update channel and which cue sounds to mute.

## Install

1. Install the module from your Xposed manager's repository list, or download `vdextra-<version>.apk` from [Releases](https://github.com/Xposed-Modules-Repo/io.github.git_morin.vdextra/releases).
2. Enable **VDExtra** in your Xposed manager; its static scope should default to Virtual Desktop.
   1. Make sure the **Virtual Desktop** app is checked in the module's app scope. From **VD** 1.34.25 the app is listed as **Virtual Desktop Android**; older versions as **Virtual Desktop**.
3. Restart Virtual Desktop if it was running. This is required whenever you change the module's config.
   1. Open the companion app to configure the module further than its default.

## Source

Source, issues and the development history live in
[git-morin/io.github.git_morin.vdextra](https://github.com/git-morin/io.github.git_morin.vdextra).

## License

[MIT](https://github.com/git-morin/io.github.git_morin.vdextra/blob/main/LICENSE).
