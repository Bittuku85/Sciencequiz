# Firebase Setup Instructions

## Permission Denied Error Fix

The `permission-denied` error occurs because Firestore security rules are preventing access to the database. Here's how to fix it:

## Step 1: Firebase Console Setup

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Select your project (or create a new one)
3. Enable Authentication and Firestore

## Step 2: Enable Authentication

1. Go to **Authentication** → **Sign-in method**
2. Enable **Email/Password** provider
3. Save the changes

## Step 3: Update Firestore Rules

### Option A: Development Rules (Easy but less secure)
1. Go to **Firestore Database** → **Rules**
2. Replace the rules with content from `firestore-dev.rules`:

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // DEVELOPMENT RULES - LESS RESTRICTIVE FOR TESTING
    match /{document=**} {
      allow read, write: if request.auth != null;
    }
    
    // Allow unauthenticated read for tournaments
    match /tournaments/{tournamentId} {
      allow read: if true;
    }
    
    // Allow unauthenticated read for settings
    match /settings/{settingId} {
      allow read: if true;
    }
  }
}
```

### Option B: Production Rules (Recommended)
1. Use the rules from `firestore.rules` for better security
2. This requires proper user authentication and admin setup

## Step 4: Update Firebase Configuration

1. Go to **Project Settings** → **General** → **Your apps**
2. Find your web app configuration
3. Copy the config object
4. Replace the config in both `admin.html` and `user.html`:

```javascript
const firebaseConfig = {
  apiKey: "your-actual-api-key",
  authDomain: "your-project.firebaseapp.com",
  projectId: "your-project-id",
  storageBucket: "your-project.appspot.com",
  messagingSenderId: "123456789",
  appId: "your-app-id"
};
```

## Step 5: Test the Setup

### For Admin Panel:
1. Open `admin.html`
2. Login with: `Rprasada273@gmail.com` / `59029400`
3. Check if data loads without permission errors

### For User Panel:
1. Open `user.html`
2. Register a new account or login
3. Check if tournaments load properly

## Troubleshooting Permission Errors

### Common Issues:

1. **"permission-denied" on tournaments**
   - Solution: Enable public read access for tournaments collection
   - Or ensure user is authenticated before loading

2. **"permission-denied" on user data**
   - Solution: Make sure user is properly authenticated
   - Check if authentication state is persistent

3. **"permission-denied" on admin functions**
   - Solution: Ensure admin document exists in `/admins/{uid}` collection
   - Verify admin privileges in Firestore rules

### Quick Fix Commands:

```javascript
// Check authentication status
console.log('Auth user:', firebase.auth().currentUser);

// Test database write permission
firebase.firestore().collection('test').add({test: true})
  .then(() => console.log('Write successful'))
  .catch(err => console.log('Write failed:', err));

// Check if user is admin
firebase.firestore().collection('admins').doc(firebase.auth().currentUser.uid).get()
  .then(doc => console.log('Is admin:', doc.exists));
```

## Security Notes

- Development rules are less secure - only use for testing
- Production rules require proper authentication setup
- Always test rules before deploying to production
- Monitor Firestore usage to prevent abuse

## Current Error Handling

The application now includes:
- ✅ Better error messages for permission issues
- ✅ Fallback behavior when data can't be loaded
- ✅ User-friendly notifications
- ✅ Automatic retry mechanisms
- ✅ Connection status indicators

Follow these steps to resolve permission denied errors completely!