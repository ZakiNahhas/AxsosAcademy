class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0
    def make_deposit(self, amount):
        self.account_balance+=amount
        return self
    def make_withdrawl(self, amount):
        self.account_balance-=amount
        return self
    def display_user_balance(self):
        print(self.account_balance)
        return self
    def transfer_money(self, other_user, amount):
        self.account_balance-=amount
        other_user.account_balance +=amount
        return self
        
        
Amin = User("Amin", "Amin@amin.com")
Zaki = User("Zaki", "Zaki@zaki.com")
Fatemah = User("Fatemah", "Fatemah@fatemah.com")

Amin.make_deposit(50).make_deposit(30).make_deposit(500).make_withdrawl(200).display_user_balance()

Zaki.make_deposit(500).make_deposit(400).make_withdrawl(500).make_withdrawl(100).display_user_balance()

Fatemah.make_deposit(2000).make_withdrawl(500).make_withdrawl(100).make_withdrawl(50).display_user_balance().transfer_money(Zaki, 100).display_user_balance()


