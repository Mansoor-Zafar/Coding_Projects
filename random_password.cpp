#include <iostream>
#include <cstring>
int main() {
    unsigned int length;
    std::cout << "Enter Password Length\n> ";
    std::cin >> length;
    const char characters[] ="abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_=-+{[]}';:/><?.,"; 
    for(auto i = 0u; i < length; ++i)
    {
        std::cout << characters[rand() % strlen(characters)];
    }
    return 0;
}
