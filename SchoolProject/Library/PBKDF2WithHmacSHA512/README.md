# PBKDF2WithHmacSHA512
PBKDF2 with Hmac SHA512 password cryptography.

[PBKDF2](http://en.wikipedia.org/wiki/PBKDF2)
[HMAC](http://en.wikipedia.org/wiki/Hash-based_message_authentication_code)
[SHA512](http://en.wikipedia.org/wiki/SHA-2)



##Usage:
```java
// The password to encrypt 
final String password = "password";

// We need to generate a random Salt before we can encrypt the password
final byte[] salt = PBKDF2WithHmacSHA512.salt();

// Now we hash the password
final byte[] hash = PBKDF2WithHmacSHA512.hash(password, salt);

// That's all we need to do to encrypt the password using PBKDF2WithHmacSHA512.

// Authentication:
final String attemptedPassword = "swagger";
boolean valid = PBKDF2WithHmacSHA512.authenticate(attemptedPassword, salt, hash);

if (valid) {
  // The password was correct
} else {
  // The password was incorrect
}
```

Note: When storing the password to a database you only need to store the salt and hash. Not the actual password itself.
