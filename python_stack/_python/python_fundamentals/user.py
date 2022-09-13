class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0
    def make_deposit(self, amount):
        self.account_balance+=amount
    def make_withdrawl(self, amount):
        self.account_balance-=amount
    def display_user_balance(self):
        print(self.account_balance)
    def transfer_money(self, other_user, amount):
        self.account_balance-=amount
        other_user.account_balance +=amount
        
        
Amin = User("Amin", "Amin@amin.com")
Zaki = User("Zaki", "Zaki@zaki.com")
Fatemah = User("Fatemah", "Fatemah@fatemah.com")

Amin.make_deposit(50)
Amin.make_deposit(30)
Amin.make_deposit(500)
Amin.make_withdrawl(200)
Amin.display_user_balance()

Zaki.make_deposit(500)
Zaki.make_deposit(400)
Zaki.make_withdrawl(500)
Zaki.make_withdrawl(100)
Zaki.display_user_balance()

Fatemah.make_deposit(2000)
Fatemah.make_withdrawl(500)
Fatemah.make_withdrawl(100)
Fatemah.make_withdrawl(50)
Fatemah.display_user_balance()
Fatemah.transfer_money(Zaki, 100)
Zaki.display_user_balance()


