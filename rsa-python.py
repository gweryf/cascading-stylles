import random
import math
 
# A set will be the collection of prime numbers,
# where we can select random primes p and q
prime = set()
 
public_key = None
private_key = None
n = None
 
# We will run the function only once to fill the set of
# prime numbers
def primefiller():
    # Method used to fill the primes set is Sieve of
    # Eratosthenes (a method to collect prime numbers)
    seive = [True] * 250
    seive[0] = False
    seive[1] = False
    for i in range(2, 250):
        for j in range(i * 2, 250, i):
            seive[j] = False
 
    # Filling the prime numbers
    for i in range(len(seive)):
        if seive[i]:
            prime.add(i)
 
 
# Picking a random prime number and erasing that prime
# number from list because p!=q
def pickrandomprime():
    global prime
    k = random.randint(0, len(prime) - 1)
    it = iter(prime)
    for _ in range(k):
        next(it)
 
    ret = next(it)
    prime.remove(ret)
    return ret
 
 
def setkeys():
    global public_key, private_key, n
    prime1 = pickrandomprime()  # First prime number
    prime2 = pickrandomprime()  # Second prime number
 
    n = prime1 * prime2
    fi = (prime1 - 1) * (prime2 - 1)
 
    e = 2
    #e should be choosen such that gcd(e,phi(n)) ==1 
    while True:
        if math.gcd(e, fi) == 1:
            break
        e += 1
 
    # d = (k*Φ(n) + 1) / e for some integer k
    public_key = e
 
    d = 2
    while True:
        if (d * e) % fi == 1:
            break
        d += 1
 
    private_key = d
 
 
# To encrypt the given number
def encrypt(message):
    global public_key, n
    e = public_key
    encrypted_text = 1
    while e > 0:
        encrypted_text *= message
        encrypted_text %= n
        e -= 1
    return encrypted_text
 
 

# To decrypt the given number
def decrypt(encrypted_text):
    global private_key, n
    d = private_key
    decrypted = 1
    while d > 0:
        decrypted *= encrypted_text
        decrypted %= n
        d -= 1
    return decrypted
 
 

# First converting each character to its ASCII value and
# then encoding it then decoding the number to get the
# ASCII and converting it to character
def encoder(message):
    encoded = []
    # Calling the encrypting function in encoding function
    for letter in message:
        encoded.append(encrypt(ord(letter)))
    return encoded
 
 
def decoder(encoded):
    s = ''
    # Calling the decrypting function decoding function
    for num in encoded:
        s += chr(decrypt(num))
    return s
 
 
if __name__ == '__main__':
    primefiller()
    setkeys()
    message = "Test Message"
    #message = input("Enter the message\n")
    coded = encoder(message)
    print(coded)
    print("Initial message:")
    print(message)
    print("\n\nThe encoded message(encrypted by public key)\n")
    print(''.join(str(p) for p in coded))
    print("\n\nThe decoded message(decrypted by public key)\n")
    print(''.join(str(p) for p in decoder(coded)))




































# Certainly!

# The primefiller() function is responsible for generating a set of prime numbers that will be used in the RSA algorithm to generate the public and private keys.

# The function starts by creating an empty set called prime. The prime set will contain all the prime numbers generated by the function.

# Next, the function creates a boolean list called seive of size 250. The seive list is used to implement the Sieve of Eratosthenes algorithm.

# The Sieve of Eratosthenes algorithm is a simple and efficient algorithm for finding all prime numbers up to a specified limit. It works by iteratively marking as composite (i.e., not prime) the multiples of each prime, starting with the multiples of 2. The algorithm can be implemented as follows:

# Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
# Initially, let p equal 2, the smallest prime number.
# Enumerate the multiples of p by counting in increments of p from 2p to n, and mark them in the list (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
# Find the smallest number in the list greater than p that is not marked. If there was no such number, stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.
# The above algorithm is used to mark all the composite numbers in the seive list.

# Next, the function iterates through the seive list and adds each prime number to the prime set. If the seive list contains True at a particular index, it means that the index is a prime number.

# Once the function has iterated through the entire seive list, the prime set will contain all the prime numbers from 0 to 250.

# Overall, the primefiller() function uses the Sieve of Eratosthenes algorithm to generate a set of prime numbers which will be used to select random prime numbers to generate the public and private keys in the RSA algorithm.





# Certainly! The pickrandomprime() function is used to randomly select a prime number from the prime set generated by the primefiller() function. Here is a step-by-step explanation of how it works:

# The function uses the built-in random.randint(a, b) function to generate a random integer k between 0 and len(prime) - 1, inclusive.

# It then creates an iterator over the prime set using the built-in iter() function.

# The function then calls the next() function on the iterator k times to skip over the first k primes in the set.

# The function then calls next() on the iterator again to retrieve the k+1th prime in the set, which is the prime number that will be returned.

# Finally, the function removes the selected prime number from the prime set using the set.remove() method to ensure that the same prime number is not selected again.

# Overall, this function ensures that two distinct prime numbers can be selected by repeatedly calling it twice without the chance of the same prime number being selected twice.
















# # Python for RSA asymmetric cryptographic algorithm.
# # For demonstration, values are
# # relatively small compared to practical application
# import math
 
 
# def gcd(a, h):
#     temp = 0
#     while(1):
#         temp = a % h
#         if (temp == 0):
#             return h
#         a = h
#         h = temp
 
 
# p = 3
# q = 7
# n = p*q
# e = 2
# phi = (p-1)*(q-1)
 
# while (e < phi):
 
#     # e must be co-prime to phi and
#     # smaller than phi.
#     if(gcd(e, phi) == 1):
#         break
#     else:
#         e = e+1
 
# # Private key (d stands for decrypt)
# # choosing d such that it satisfies
# # d*e = 1 + k * totient
 
# k = 2
# d = (1 + (k*phi))/e
 
# # Message to be encrypted
# msg = 12.0
 
# print("Message data = ", msg)
 
# # Encryption c = (msg ^ e) % n
# c = pow(msg, e)
# c = math.fmod(c, n)
# print("Encrypted data = ", c)
 
# # Decryption m = (c ^ d) % n
# m = pow(c, d)
# m = math.fmod(m, n)
# print("Original Message Sent = ", m)
 
 
# # This code is contributed by Pranay Arora.