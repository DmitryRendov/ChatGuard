# Quick Start Guide - Building ChatGuard

## System Requirements
- **Java:** 21+ (tested with Java 25.0.3)
- **Gradle:** 8.5 (included via wrapper)
- **Disk Space:** ~500 MB (for Gradle cache + build)

## Building the Plugin

### Step 1: Clone/Navigate to Project
```bash
cd /home/dmitry/repos/ChatGuard
```

### Step 2: Build
```bash
# Standard build
./gradlew clean build

# Or with explicit Java version
JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64 ./gradlew clean build

# Quick rebuild (skip clean)
./gradlew build
```

### Step 3: Find JAR
```
build/libs/ChatGuard-7.7.0.jar
```

That's it! The JAR is ready to deploy.

---

## Deployment

1. **Copy to Server:**
   ```bash
   cp build/libs/ChatGuard-7.7.0.jar /path/to/server/plugins/
   ```

2. **Optional: Add Optional Dependencies**
   - Copy ProtocolLib JAR (if downloaded) to `plugins/`
   - Copy NoCheatPlus JAR (if downloaded) to `plugins/`

3. **Restart Server**
   ```bash
   # Server console
   stop
   # Wait for save, then restart
   ```

4. **Verify**
   ```
   [ChatGuard] ChatGuard enabled!
   ```

---

## Common Issues & Solutions

### Issue: "Could not find java"
**Solution:** Ensure Java 21+ is installed
```bash
java -version  # Should show 21.x or higher
```

### Issue: "Gradle build fails"
**Solution:** Clear caches and retry
```bash
rm -rf .gradle build
./gradlew clean build
```

### Issue: "Plugin works but features missing"
**Solution:** Download optional dependencies
- See `OPTIONAL_DEPENDENCIES.md`

### Issue: "Class not found: org.bstats"
**Solution:** Ensure ChatGuard JAR is properly shaded
- Check that `ChatGuard-7.7.0.jar` contains bstats bundled
- Re-extract with: `jar tf build/libs/ChatGuard-7.7.0.jar | grep bstats`

---

## What's New

### ✅ Fixed in This Version
- ✅ **Java 21 support** (from Java 8)
- ✅ **Gradle 8.5** (from broken wrapper)
- ✅ **Minecraft 1.20.6 API** (from 1.13.2)
- ✅ **All dependencies resolved**
- ✅ **Build reproducible** (no Eclipse project required)

### 📝 Version History
- **7.7.0** - Modern Java 21, Minecraft 1.20.6 (this build)
- **7.6.2** - Last version before modernization (had broken build)

---

## Development

### IDE Setup (VS Code / IntelliJ)
1. Open project root in IDE
2. IDE should auto-detect Gradle project
3. Run > Run Tasks > build

### Command Line Build Variations

```bash
# Full build with all checks
./gradlew clean build --info

# Skip tests (faster)
./gradlew build -x test

# Just compile (no JAR)
./gradlew compileJava

# Show deprecated warnings
./gradlew build --warning-mode all

# Parallel build (faster)
./gradlew build --parallel

# Daemon info
./gradlew --status
./gradlew --stop  # Stop daemon
```

### Project Structure
```
ChatGuard/
├── src/main/java/         # Source code
├── src/main/resources/     # Config files (plugin.yml, configs)
├── build/
│   └── libs/
│       └── ChatGuard-7.7.0.jar  ← Output JAR
├── gradle/
│   └── wrapper/            # Gradle 8.5 wrapper
├── build.gradle            # Build configuration
├── settings.gradle         # Project settings
└── gradlew                 # Build script (Linux/Mac)
```

---

## Next Steps

### If You Have ProtocolLib/NoCheatPlus
1. Place JAR files in `lib/` folder
2. Run `./gradlew clean build` again
3. Features will be included

### If Deploying to Server
1. Stop server
2. Copy `ChatGuard-7.7.0.jar` to `plugins/`
3. Restart server
4. Check logs: `tail -f logs/latest.log | grep ChatGuard`

### If Modifying Code
1. Edit files in `src/main/java/`
2. Run `./gradlew compileJava` to check syntax
3. Run `./gradlew build` when ready
4. Test in server

---

## Support

- **Build Issues:** Check `BUILD_REPORT.md`
- **Optional Deps:** Check `OPTIONAL_DEPENDENCIES.md`
- **Plugin Docs:** See `plugin.yml` for commands/permissions

**Last Updated:** 2026-06-21
