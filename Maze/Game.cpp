#include <iostream>
#include "Game.h"

namespace maze
{
	namespace //only avaiable to this file
	{
		void setMatrixDimensions(size_t& row, size_t& col)
		{
			while (true)
			{
				std::cout << "\n----------------\nEnter the amount of rows (must be atleast 3)\n> ";
				if (std::cin >> row)
					std::cout << "Enter the amount of columns (must be atleast 3)\n> ";
				if (std::cin >> col)
					if (row >= 3 && col >= 3)
						break;
				std::cout << "Invalid Input, Try Again\n";
				std::cin.clear();
				std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
			}
		}

		void setUser(Map& map)
		{
			std::cout << "\n-----------------\n";
			char symbol{};
			std::string toRead{};

			std::cout << "Enter your icon!\n(It will only be the first character you input)\nEx. @lol \n-> icon would be: @\n> "; 
			std::cin >> toRead;
			
			symbol = toRead[0];
			map.setPlayer(symbol);
		}
	}

	void play()
	{
		std::cout << "Welcome! In this game you move through with the arrow keys <W A S D>\n" <<
			"Just Enter the key and you'll move in that set direction\n" << 
			"W: Up\nA: Left\nS: Down\nD: Right\n" << 
			"\nYou'll progress through the maze to get to the end!\n" << 
			"The end will always be marked as 'x'\n";

		size_t row{}, col{};
		setMatrixDimensions(row, col);
		Map map(row,col);
		
		
		setUser(map);
		map.gameLoop();
		
	}

}