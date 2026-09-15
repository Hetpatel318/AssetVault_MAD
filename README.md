# AssetVault 🛡️

**AssetVault** is a robust personal asset management Android application. It allows users to digitize their physical belongings by tracking purchase details, categories, and warranty information in a clean, offline-first environment.

## 🚀 Features

- **Dashboard**: Real-time overview showing total assets and warranty alerts.
- **Full CRUD Management**: Add new assets, view details, edit information, and delete records seamlessly.
- **Categorized View**: Automatically groups assets by category (e.g., Electronics, Furniture) and calculates total valuation for each.
- **Warranty Tracker**: Dedicated section to monitor assets with active warranty periods.
- **Offline Reliability**: Built using **SQLite**, ensuring your data stays private and accessible without an internet connection.
- **Clean UI/UX**: Intuitive Material Design interface for easy navigation from the entry screen to specific asset details.

## 🛠️ Tech Stack

- **Language**: [Kotlin](https://kotlinlang.org/)
- **Database**: SQLite (via `SQLiteOpenHelper`)
- **UI Framework**: XML Layouts with Material Design
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 37 (Android 15)

## 📂 Project Highlights

- **EntryActivity**: A welcoming landing screen to start the app.
- **AssetDatabaseHelper**: Handles all database operations including table creation and CRUD queries.
- **MainActivity**: The core dashboard linking to all major features.
- **AssetCategoriesActivity**: Provides high-level insights into your asset distribution.

## 📥 Getting Started

1.  **Clone the Repo**:
    ```bash
    git clone https://github.com/Hetpatel318/AssetVault_MAD.git
    ```
2.  **Open in Android Studio**: Select the root folder and wait for Gradle sync to complete.
3.  **Run**: Click the "Run" button to deploy on your emulator or physical device (Android 7.0+).

## 📄 License

Distributed under the MIT License. See `LICENSE` for more information.

---
*Developed for the Mobile Application Development (MAD) Assignment.*
