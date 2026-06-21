# Dependency Status for ChatGuard 7.7.0

## Required Dependencies
- **Spigot/Bukkit API 1.20.6** - Available from https://hub.spigotmc.org/nexus/
  - Status: ✓ AVAILABLE

## Bundled Dependencies
- **bstats-bukkit 3.0.2** - Metrics library
  - Status: ✓ AVAILABLE (Maven Central)

## Optional Soft Dependencies (required for full features)

### AuthMe 5.6.0
- For authentication integration
- Status: Checking repositories...

### ProtocolLib
- For packet manipulation
- Official: https://github.com/dmulloy2/ProtocolLib
- Available versions in public repos: Need to download from releases

### NoCheatPlus
- For anti-cheat integration
- Official: https://github.com/Updated-NoCheatPlus/NoCheatPlus
- Status: May need to be downloaded manually

## Solution
Since these are optional soft-dependencies, the plugin can build without them.
To build with these libraries, download them from their official GitHub releases
and place them in the lib/ folder, or modify the build.gradle to use local dependencies.
