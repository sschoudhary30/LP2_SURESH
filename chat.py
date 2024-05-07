import random
from datetime import date, datetime

# Define responses
responses = {
    "hi": ["Hello!", "Hi there!", "Hey! How can I help you?"],
    "how are you": ["I'm doing well, thank you for asking!", "Feeling good today!", "I'm great, thanks!"],
    "bye": ["Goodbye!", "See you later!", "Bye! Have a great day!"],
    "thanks": ["You're welcome!", "No problem!", "Anytime!"],
    "what's your name": ["I'm just a simple chatbot!", "I'm your friendly neighborhood chatbot.", "I don't have a name, I'm just here to assist you!"],
    "what can you do": ["I can help you with basic information and simple tasks.", "Feel free to ask me questions or for assistance!", "I can provide answers to common queries and engage in conversation."],
    "what is date today": str(date.today()),
    "what is time": str(datetime.now().strftime("%H:%M:%S")),
    "what is day today": str(date.today().strftime("%A")),
    "what is month today": str(date.today().strftime("%B")),
    "what is year today": str(date.today().strftime("%Y"))
}

# Function to generate response
def get_response(message):
    message = message.lower()
    if message in responses:
        if message == "what is date today":
            return responses[message]
        elif message == "what is time":
            return responses[message]
        elif message == "what is day today":
            return responses[message]
        elif message == "what is month today":
            return responses[message]
        elif message == "what is year today":
            return responses[message]
        else:
            return random.choice(responses[message])
    else:
        return "I'm sorry, I don't understand that. You can ask me something else."

# Main function
def main():
    print("Welcome to Simple Chatbot!")
    print("Type 'bye' to exit.")
    
    while True:
        user_input = input("You: ")
        if user_input.lower() == 'bye':
            print(get_response(user_input))
            break
        else:
            response = get_response(user_input)
            if isinstance(response, list):
                for item in response:
                    print("Bot:", item)
            else:
                print("Bot:", response)

if __name__ == "__main__":
    main()
