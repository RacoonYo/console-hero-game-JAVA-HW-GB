import re
from time import sleep
from classes import Printer, Scanner, Copier, Warehouse


warehouse_dict = {}
printers_list = []
scanners_list = []
copiers_list = []


def is_number(txt: str):
    try:
        float(txt)
        return True
    except ValueError:
        return False


def create_new_warehouse():
    while True:
        wh_name = input('Please, enter name warehouse: ')
        if warehouse_dict.get(wh_name):
            print("this name already exists, enter a unique name")
            continue
        else:
            break

    location = input(f'Please, enter where is location {wh_name}: ')

    while True:
        size = input('Please, enter size your warehouse: ')
        if not is_number(size):
            print("size is number!!!")
            continue
        else:
            break

    warehouse_dict[wh_name] = Warehouse(location, float(size))
    return wh_name


def add_printer(wh_name):
    model = input('please, enter printer model: ')
    while True:
        dimension = input('please, enter dimension in format WWW*HHH*LLL: ')
        if re.fullmatch(r'(?:\d+(?:\.\d+)*\*){2}\d+(?:\.\d+)*', dimension):
            break
        else:
            print('invalid format')
            continue
    while True:
        color = input('please, enter "C" if color printer and "B" if black and white printer: ')
        if color.strip().upper() == "C":
            color = True
            break
        elif color.strip().upper() == "B":
            color = False
            break
        else:
            print('invalid command')
            continue
    paper_format = input('enter printer paper format: ')
    pr_technology = input('enter print technology: ')
    while True:
        quantity = input('Please, enter quantity printers: ')
        if quantity.strip().isdigit():
            break
        else:
            print("quantity is number!!!")
            continue

    printer = Printer(model, dimension, color, paper_format, pr_technology)
    scanners_list.append(printer)
    warehouse_dict[wh_name].add_to_warehouse(printer, int(quantity))


def add_scaner(wh_name):
    model = input('please, enter scaner model: ')
    while True:
        dimension = input('please, enter dimension in format WWW*HHH*LLL: ')
        if re.fullmatch(r'(?:\d+(?:\.\d+)*\*){2}\d+(?:\.\d+)*', dimension):
            break
        else:
            print('invalid format')
            continue
    while True:
        color = input('please, enter "C" if color scaner and "B" if black and white scaner: ')
        if color.strip().upper() == "C":
            color = True
            break
        elif color.strip().upper() == "B":
            color = False
            break
        else:
            print('invalid command')
            continue
    paper_format = input('enter scanner paper format: ')
    sk_type = input('enter scanning type: ')
    while True:
        quantity = input('Please, enter quantity scanners: ')
        if quantity.strip().isdigit():
            break
        else:
            print("quantity is number!!!")
            continue

    scaner = Scanner(model, dimension, color, paper_format, sk_type)
    scanners_list.append(scaner)
    warehouse_dict[wh_name].add_to_warehouse(scaner, int(quantity))


def add_copier(wh_name):
    model = input('please, enter copier model: ')
    while True:
        dimension = input('please, enter dimension in format WWW*HHH*LLL: ')
        if re.fullmatch(r'(?:\d+(?:\.\d+)*\*){2}\d+(?:\.\d+)*', dimension):
            break
        else:
            print('invalid format')
            continue
    while True:
        color = input('please, enter "C" if color copier and "B" if black and white copier: ')
        if color.strip().upper() == "C":
            color = True
            break
        elif color.strip().upper() == "B":
            color = False
            break
        else:
            print('invalid command')
            continue

    paper_format = input('enter copier paper format: ')
    copy_type = input('enter copy type: ')

    while True:
        copy_speed = input('enter copy speed (sheets per minute): ')
        if copy_speed.strip().isdigit():
            break
        else:
            print("speed is number!!!")
            continue

    while True:
        quantity = input('Please, enter quantity printers: ')
        if quantity.strip().isdigit():
            break
        else:
            print("quantity is number!!!")
            continue

    copier = Copier(model, dimension, color, paper_format, copy_type, int(copy_speed))
    copiers_list.append(copier)
    warehouse_dict[wh_name].add_to_warehouse(copier, int(quantity))


if __name__ == '__main__':
    print('creating new warehouse')
    wh_name = create_new_warehouse()
    while True:
        command = input('enter "1" if you want to add the printer to the warehouse\n'
                        'enter "2" if you want to add the scaner to the warehouse\n'
                        'enter "3" if you want to add the copier to the warehouse\n'
                        'enter "M" if you want to look what put to the warehouse\n'
                        'enter "Q" if you want to exit\n')

        if command.strip() == '1':
            add_printer(wh_name)
        elif command.strip() == '2':
            add_scaner(wh_name)
        elif command.strip() == '3':
            add_copier(wh_name)
        elif command.strip().upper() == 'M':
            print(warehouse_dict[wh_name].register_book)
        elif command.strip().upper() == 'Q':
            exit()
        else:
            print('Invalid command!!!')
        print('\n')
        sleep(2)