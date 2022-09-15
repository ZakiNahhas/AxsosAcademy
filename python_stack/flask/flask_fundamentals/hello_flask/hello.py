from flask import Flask, render_template # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"
# @app.route('/<name>')      # The "@" decorator associates this route with the function immediately following
# def hello_world(name):
#     return f'Hello {name}'
# @app.route('/success')
# def success():
#   return "success"          # Return the string 'Hello World!' as a response
@app.route('/')                           
def hello_worl():
    return render_template('index.html', phrase="hello", times=5)
if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)  