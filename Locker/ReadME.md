Lock your Personal Data Using Encryption And Use A USB device as a key to it.

Changed the files so that single file can be used to Setup, Encrypt, Decrypt.

Setup can be used to change the device only if current state is decrypted.

If the file is not decrypted, the key cannot be changed.


#use the -lcrypto++ tag after the file to compile it.

` g++ -std=c++11 Encrypter.cpp -lcrypto++ `

needs the crypto++ library

` sudo apt-get install libcrypto++-dev `
