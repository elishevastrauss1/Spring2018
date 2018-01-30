def choices():
    choice=input("""Choose
        1-Make a list
        2-Add an item
        3-Delete a specified item
        4-Change an item
        5-See if something exists in the array
        6-Output the list
        7-Quit""")
    return choice

def initilize():
    global array
    array=("")

def add(inp):
    array+=inp

def delete(inp):
    array.remove(inp)

def change(inp,new):
    index=array.index(inp)
    array[index]=new

def find(inp):
    try:
        array.index(inp)
        print("Is in the list")
    except:
        print("Is not in the list")
def output():
    for item in array:
        print(item)

#main
while True:        
    choice=choices()
    if choice=="1":
        initilize()
    elif choice=="2":
        inp=input("What whould you like to add?")
        add(inp)
    elif choice=="3":
        inp=input("What would you like to delete?")
        delete(inp)
    elif choice=="4":
        inp=input("What do you want to replace?")
        new=input("What are you replacing with?")
        change(inp,new)
    elif choice=="5":
        inp=input("What do you want to find?")
        find(inp)
    elif choice=="6":
        output()
    elif choice!="7" :
        print("Invalid choice")
    else:
        break
