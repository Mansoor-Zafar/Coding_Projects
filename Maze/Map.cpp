
#include "Map.h"
#include "Timer.h"
#include "Player.h"

namespace maze
{
	namespace //Below obj's cannot be accessed anywhere else
	{
		enum class Environment
		{
			Wall = '|', Space = ' ', Top = '-', Goal = 'x'
		};		
	}
	
	


	//TO KNOW: *(*(this->map + i) + j) IS THE SAME AS : this->map[i][j]
	//TO KNOW: *(this->map + i) IS THE SAME AS : this->map[i];

	Map::Map(const size_t& row, const size_t& col) : row{ row }, col{col}, middle(row/col)
	{
		this->map = new char* [this->row];

		for (auto i = 0u; i < this->row; ++i)
		{
			*(this->map + i) = new char[col];
		}

		//By default player will start in the middle:
		Player.x = this->row / 2;
		Player.y = this->col / 2; 
		
		*(*(this->map + 1) + 1) = char(Environment::Goal);
			
	}

	void Map::print() const
	{
		for (auto i = 0u; i < this->row; ++i)
		{
			for (auto j = 0u; j < this->col; ++j)
				std::cout << *(*(this->map + i) + j); // = to cout << this->map[i][j];
			std::cout << "\n";
		}
	}

	void Map::menu()
	{
		std::cout << "Welcome to maze!";
	}

	void Map::set()
	{
		for (auto i = 0u; i < this->row; ++i)
		{
			for (auto j = 0u; j < this->col; ++j)
			{
				if (i == Player.x && j == Player.y)
				{
					//this->map[Player.x][Player.y]
					*(*(this->map + i) + j) = Player.icon;
					continue;
				}
				if (*(*(this->map + i) + j) == char(Environment::Goal))
					continue;
				if (i == 0 || i == this->row - 1)
				{
					*(*(this->map + i) + j) = char(Environment::Top);
					continue;
				}
				if (j == 0 || j == this->col - 1)
				{
					*(*(this->map+i)+j) = char(Environment::Wall);
					continue;
				}
				*(*(this->map + i) + j) = char(Environment::Space);
			}
		}
	}

	void Map::setPlayer(const char& symbol)
	{
		Player.icon = symbol;
	}

	
	void Map::moveUser(const size_t& x, const size_t& y)
	{
		if ((x >= this->row || x <= 0) || (y >= this->col || y <= 0))
			return;

		if (*(*(this->map + x) + y) != char(Environment::Wall) && *(*(this->map + x) + y) != char(Environment::Top))
		{
			Player.x = x;
			Player.y = y;
		}
	}

	void Map::gameLoop()
	{
		while (true)
		{
			if (*(*(this->map + Player.x) + Player.y) == char(Environment::Goal))
				break;
			this->set();
			this->print();

			char key{};
			std::string toRead{};
			std::cout << "Move: <WASD>\n> ";
			if (std::cin >> toRead)
			{
				key = toRead[0];
				key = char(std::tolower(key));
				switch (key)
				{
				case 'w': this->moveUser(Player.x-1, Player.y);	break;
				case 'a': this->moveUser(Player.x, Player.y-1);	break;
				case 's': this->moveUser(Player.x+1, Player.y);	break;
				case 'd': this->moveUser(Player.x, Player.y+1); break;
				default: std::cout << "Invalid Choice\n";		break;
				}
			}
		}
		this->endGame();
	}

	void Map::endGame()
	{
		std::cout << "Congrats You got to the end!";
	}
	


	
	////////////////////////////////////////////
	//------------- DESTRUCTOR ---------------//
	////////////////////////////////////////////
		
	Map::~Map()
	{
		for (auto i = 0u; i < this->row; ++i)
			delete[] *(this->map+i); //ptr arithmatic : same as this->map[i];
		delete[] this->map;
	}

}