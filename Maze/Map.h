#ifndef MAZE_MAP_H
#define MAZE_MAP_H

namespace maze
{

	class Map
	{
	private:
		char** map{};
		size_t row{};
		size_t col{};
		const size_t middle;

		void moveUser(const size_t& x, const size_t& y);
		
		void endGame();

	public:
		//Constructors
		Map() = default;
		Map(const size_t& row, const size_t& col);
		void set();
		void print() const;
		void setPlayer(const char& symbol);
		void gameLoop();
		void menu();

		~Map();
	};

}

#endif