# Optional Dependencies Setup Guide

## Overview
ChatGuard has optional soft dependencies on ProtocolLib and NoCheatPlus. The plugin will work without these, but some features require them.

## Dependencies Status

### ✅ Already Included (compile + runtime)
- **Apache Commons Lang** 2.6 - String utilities
- **bstats** 1.8 - Analytics library  
- **AuthMe** 5.4.0 - Authentication integration

### ⚠️  Optional (soft dependencies)
These are optional and the plugin builds without them, but they're needed for full features:

| Library | Feature | Version | Location |
|---------|---------|---------|----------|
| ProtocolLib | Packet manipulation, chat filtering | 4.8.0 - 5.x | [GitHub](https://github.com/dmulloy2/ProtocolLib/releases) |
| NoCheatPlus | Anti-cheat integration | 3.16.0-RC | [GitHub](https://github.com/Updated-NoCheatPlus/NoCheatPlus/releases) |

---

## How to Add Optional Dependencies

### Option 1: Download and Add to lib/ Folder (RECOMMENDED)

1. **Create lib folder** (if it doesn't exist):
   ```bash
   mkdir -p lib
   ```

2. **Download ProtocolLib:**
   - Go to https://github.com/dmulloy2/ProtocolLib/releases
   - Download a version compatible with your Minecraft version (e.g., `ProtocolLib-5.0.0.jar`)
   - Place in `lib/` folder

3. **Download NoCheatPlus:**
   - Go to https://github.com/Updated-NoCheatPlus/NoCheatPlus/releases
   - Download the latest compatible version (e.g., `NoCheatPlus-3.16.0-RC.jar`)
   - Place in `lib/` folder

4. **Rebuild:**
   ```bash
   ./gradlew clean build
   ```

   The JAR files from `lib/` will be automatically included in the compilation classpath.

### Option 2: Manual Maven Repository Setup

If you want to pull from Maven repositories directly, update `build.gradle`:

```gradle
dependencies {
    // ... existing dependencies ...
    
    // Add these compileOnly dependencies if you can find them
    compileOnly 'com.comphenix.protocol:ProtocolLib:5.0.0'
    compileOnly 'fr.neatmonster:nocheatplus:3.16.0-RC'
}
```

However, these versions are not available in public Maven repositories, so **Option 1 is recommended**.

---

## Checking Installation

### Verify Plugin Loads
When you run the plugin on a server with ProtocolLib and/or NoCheatPlus installed, the console will show:
```
[ChatGuard] ProtocolLib found!
[ChatGuard] NoCheatPlus found!
```

### Features by Dependency

| Feature | Without ProtocolLib | With ProtocolLib |
|---------|-------------------|------------------|
| Packet-based chat filtering | ❌ Disabled | ✅ Enabled |
| Private message commands via packets | ❌ Disabled | ✅ Enabled |

| Feature | Without NoCheatPlus | With NoCheatPlus |
|---------|-------------------|------------------|
| Anti-cheat integration | ❌ Disabled | ✅ Enabled |
| Captcha system | ❌ Disabled | ✅ Enabled |

---

## Troubleshooting

### Build Fails with "Cannot find symbol: class PacketType"
This means ProtocolLib stub is not being used correctly. Check:
- Ensure you're using `./gradlew` from project root
- Delete `.gradle` folder and retry: `rm -rf .gradle && ./gradlew clean build`

### Plugin Starts But Optional Features Missing
This is **normal** - it means the optional dependencies aren't installed on the server. The plugin will still work for core features.

### Runtime "ClassNotFoundException" for ProtocolLib/NoCheatPlus
Add the JAR files to the server's `plugins/` folder alongside ChatGuard.jar

---

## Advanced: Using Remote Repositories

If you find these libraries in a Maven repository, you can add custom repos to `build.gradle`:

```gradle
repositories {
    // ... existing repos ...
    
    // Example: custom nexus repo
    maven { url "https://your-custom-repo/nexus/" }
}

dependencies {
    compileOnly 'com.example:protocollib:5.0.0'
}
```

---

## Version Compatibility

### Tested Combinations
- ✅ Minecraft 1.20.x + Java 21 + Gradle 8.5
- ✅ Minecraft 1.19.x (should work)
- ✅ Minecraft 1.18.x (should work)

### Java Version Support
- ✅ Java 21 (primary target)
- ✅ Java 25+ (forward compatible)
- ⚠️  Java 17 LTS (if using Java 17 compatible build)
- ❌ Java 8 (too old, not supported by modern Bukkit)

---

## Need Help?

If you encounter issues with optional dependencies:

1. Check GitHub releases for the libraries
2. Try without optional dependencies first
3. Add one library at a time to isolate issues
4. Check server logs for ClassNotFoundException or version conflicts

---

**Last Updated:** 2026-06-21  
**Gradle Version:** 8.5  
**Java Target:** 21
