from game import Game

def main():
    g = Game()

    while True:
        g.add_move()
        g.show_level()
        if not g.test_player():
            print("Sorry, that was wrong")
            break

    print("Game Over")

if __name__ == '__main__':
    main()