# Roulette Release Project

This project rebuilds the uploaded APK as a normal Android WebView project using the HTML found in `assets/index.html`.

Package name preserved from the uploaded APK: `com.example.myapp`.

## GitHub Actions

The workflow at `.github/workflows/release-apk.yml` builds a signed Release APK.

Required repository secrets:
- `RELEASE_KEYSTORE_B64`
- `RELEASE_STORE_PASSWORD`
- `RELEASE_KEY_ALIAS`
- `RELEASE_KEY_PASSWORD`

Run: GitHub → Actions → Build Release APK → Run workflow.
