from flask import Flask, render_template, request, redirect, session
app = Flask(__name__) 
app.secret_key = 'ABCDEFU'
@app.route('/form')
def form():
    return render_template("form.html")

@app.route('/handlesubmit', methods = ['POST'])
def handleform():
    session['Username'] = request.form['Username']
    session['Email'] = request.form['Email']
    session['fav'] = request.form['fav']
    print(request.form)
    
    
    return redirect("/show")
@app.route('/show')
def showdata():
    return render_template("form2.html", uname = session['Username'], email1 = session['Email'], fav_color = session['fav'])

if __name__=="__main__":  
    app.run(debug=True)  