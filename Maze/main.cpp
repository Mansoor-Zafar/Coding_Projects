#include <iostream>
#include "Game.h"


int main()
{
	_CrtSetDbgFlag(_CRTDBG_ALLOC_MEM_DF | _CRTDBG_LEAK_CHECK_DF);

	maze::play();

	std::cout << "\n\nGoodbye!";
}