from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/division')
def operacion():
    a=float(request.args.get('a', 0))
    b=float(request.args.get('b', 0))
    if b == 0:
        return jsonify({'error': 'No hay division pa 0'}), 400
    return jsonify({'resultado': a / b})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5004)