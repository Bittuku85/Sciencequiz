# 🔥 Firebase Firestore Security Rules Guide

## 📋 Available Rules Files

This repository contains two Firestore security rules files:

1. **`firestore-dev.rules`** - Development/Testing Rules (Less Restrictive)
2. **`firestore.rules`** - Production Rules (Secure)

## 🚀 Quick Setup

### For Testing/Development (Recommended First)

```bash
# Copy development rules to Firebase Console
cat firestore-dev.rules
```

### For Production Deployment

```bash
# Copy production rules to Firebase Console  
cat firestore.rules
```

## 📖 Rules Explanation

### Development Rules (`firestore-dev.rules`)

**Use Case**: Testing, Development, Demo Mode
**Security Level**: Low (Easy Testing)

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Allow all authenticated users to read/write
    match /{document=**} {
      allow read, write: if request.auth != null;
    }
    
    // Allow unauthenticated read for tournaments (testing)
    match /tournaments/{tournamentId} {
      allow read: if true;
    }
    
    // Allow unauthenticated read for settings (testing)
    match /settings/{settingId} {
      allow read: if true;
    }
  }
}
```

**Benefits**:
- ✅ No permission denied errors during development
- ✅ Easy testing without complex authentication setup
- ✅ Quick prototyping and feature development

**Warning**: ⚠️ DO NOT use in production!

### Production Rules (`firestore.rules`)

**Use Case**: Live Application, Production Deployment
**Security Level**: High (Secure)

**Key Features**:
- ✅ Users can only access their own data
- ✅ Admin-only operations are protected
- ✅ Proper access control for all collections
- ✅ Tournament registration permissions
- ✅ Secure topup request handling

## 🔧 How to Apply Rules

### Step 1: Go to Firebase Console
1. Open [Firebase Console](https://console.firebase.google.com/)
2. Select your project
3. Navigate to **Firestore Database** → **Rules**

### Step 2: Choose Your Rules
- **For Testing**: Copy content from `firestore-dev.rules`
- **For Production**: Copy content from `firestore.rules`

### Step 3: Apply Rules
1. Paste the rules in the Firebase Console
2. Click **Publish** button
3. Rules will be active immediately

## 📊 Rules Comparison

| Feature | Development Rules | Production Rules |
|---------|------------------|------------------|
| **User Data Access** | Any authenticated user | Only own data |
| **Admin Operations** | Any authenticated user | Only verified admins |
| **Tournament Read** | Public access | Authenticated users only |
| **Tournament Write** | Any authenticated user | Admins only |
| **Testing Ease** | Very Easy | Requires proper setup |
| **Security Level** | Low | High |
| **Production Ready** | ❌ No | ✅ Yes |

## 🐛 Troubleshooting

### Permission Denied Errors

**Problem**: Getting `permission-denied` errors
**Solution**: 
1. Use development rules for testing
2. Ensure user is authenticated for production rules
3. Check if admin permissions are properly set

### Demo Mode Issues

**Problem**: App running in demo mode
**Solution**:
1. Apply development rules first
2. Update Firebase configuration in HTML files
3. Ensure authentication is working

### Admin Access Issues

**Problem**: Admin functions not working
**Solution**:
1. Create admin document in `/admins/{uid}` collection
2. Add admin user's UID as document ID
3. Apply production rules

## 🔐 Security Best Practices

### For Development
- ✅ Use development rules during feature development
- ✅ Test with multiple user accounts
- ✅ Validate all user flows
- ⚠️ Never deploy development rules to production

### For Production
- ✅ Use production rules for live applications
- ✅ Set up proper admin user documents
- ✅ Test authentication flows thoroughly
- ✅ Monitor usage and access patterns

## 📝 Admin Setup Guide

### Creating Admin Users

1. **Register User**: Create account through your app
2. **Get UID**: Copy user UID from Firebase Authentication
3. **Create Admin Document**: In Firestore, create:
   ```
   Collection: admins
   Document ID: {user-uid}
   Fields: {
     email: "admin@example.com",
     role: "admin",
     createdAt: timestamp
   }
   ```

### Testing Admin Access

```javascript
// Test if user is admin
firebase.firestore().collection('admins').doc(firebase.auth().currentUser.uid).get()
  .then(doc => {
    if (doc.exists) {
      console.log('User is admin');
    } else {
      console.log('User is not admin');
    }
  });
```

## 🚀 Deployment Checklist

### Before Going Live

- [ ] Switch from development to production rules
- [ ] Set up admin user documents
- [ ] Test all authentication flows
- [ ] Verify security permissions
- [ ] Update Firebase configuration with real project
- [ ] Test with real user accounts

### Production Deployment

- [ ] Apply production rules
- [ ] Monitor error logs
- [ ] Test admin functions
- [ ] Verify user data isolation
- [ ] Check performance metrics

## 📞 Support

If you encounter any issues:

1. **Check Rules**: Ensure correct rules are applied
2. **Verify Auth**: Check if user is properly authenticated
3. **Admin Setup**: Confirm admin documents exist
4. **Console Logs**: Check browser console for detailed errors

## 🔄 Version History

- **v1.0**: Initial rules setup
- **v1.1**: Added comprehensive testing rules
- **v1.2**: Enhanced security for production
- **v1.3**: Added admin verification system

---

**💡 Tip**: Start with development rules for testing, then switch to production rules when deploying live!