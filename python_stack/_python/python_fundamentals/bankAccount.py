class Bank_account:
    def __init__(self, int_rate, balance):
        self.int_rate = int_rate
        self.balance = balance
    def deposit(self, amount):
        self.balance += amount
        return self
    def withdraw(self, amount):
        self.balance -=amount
        if self.balance <= amount:
            self.balance-=5
            print("Insufficient funds: Charging a $5 fee")
        return self
    def display_account_info(self):
            print(self.balance)
            return self
    def yield_interest(self):
        if self.balance > 1:
            self.balance-=self.balance * self.int_rate
        return self
            
ZakiAccount = Bank_account(0.02, 500)
NahhasAccount = Bank_account(0.04, 2400)



ZakiAccount.deposit(100).deposit(200).deposit(300).withdraw(200).yield_interest().display_account_info()
NahhasAccount.deposit(700).deposit(200).withdraw(200).withdraw(200).withdraw(200).withdraw(200).yield_interest().display_account_info()