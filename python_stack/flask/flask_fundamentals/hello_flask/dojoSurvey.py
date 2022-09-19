from flask import Flask, render_template, request, redirect
app = Flask(__name__) 

@app.route('/')
def form():
    return render_template("dojoSurvey1.html")

@app.route('/result',  methods = ['POST', 'GET'])
def returnshit():
    if request.method == 'POST':
        name = request.form['Username']
        location = request.form['Location']
        fav_lang = request.form['fav_lang']
        comment = request.form['Comment']
        return render_template("dojoSurvey2.html", uname =name, loc = location, favlang= fav_lang, com=comment)
    else:
        return redirect('/')

if __name__=="__main__":  
    app.run(debug=True)  