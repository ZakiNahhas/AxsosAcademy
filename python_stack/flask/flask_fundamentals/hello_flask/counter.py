from flask import Flask, render_template, redirect, request, session
app = Flask(__name__) 
app.secret_key= 'ABCDEFU'
@app.route('/')
def count():
    if 'count' in session:
        session['count']=session.get('count')+1
    else:
        session['count']=1
    return render_template( "counter.html")
@app.route('/destroy')
def destroy():
    # session.clear() # Destroy All sessions
    session.pop('count',None)
    return render_template("counter.html    ")
@app.route('/increment2')
def increment2():
    session['count']=session.get('count')+1
    return redirect('/')
@app.route('/reset')
def reset():
        session['count']=0
        return redirect('/')

if __name__=="__main__":  
    app.run(debug=True)