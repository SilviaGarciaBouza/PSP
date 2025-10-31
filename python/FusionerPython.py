import sys
import os

def readSumFrequencies(filePaths):

    globalFrequencies = {}

    for filePath in filePaths:
        try:
            with open(filePath, 'r', encoding='utf-8') as file:
                for line in file:
                    parts = line.strip().split(',')

                    if len(parts) == 2:
                        word = parts[0]
                        try:
                            frequency = int(parts[1])

                            globalFrequencies[word] = globalFrequencies.get(word, 0) + frequency
                        except ValueError:
                            print(f'Error en lectura: {parts[0]} : {parts[1]}')
                            continue
            os.remove(filePath)
        except FileNotFoundError:
            print(f'Error al abrir el fichero {filePath}')
            continue
        except OSError as e:
            print(f'Error al eliminar el archivo temporal {filePath}')

    return globalFrequencies

def print_top_frequencies(globalFrequencies):


    sortedItems = sorted(
        globalFrequencies.items(),
        key=lambda item: item[1],
        reverse=True
    )

    print("Top 5 palabras mas frecuentes:")

    for i in range(5):
        print(f'{i+1}. {sortedItems[i][0]} : {sortedItems[i][1]}')




if __name__ == '__main__':



    if len(sys.argv) < 2:
        print("Error: Se necesita al menos un argumento de salida y las rutas temporales.")
        sys.exit(1)

    tempFiles = sys.argv[1:]

    try:
        total_frequencies = readSumFrequencies(tempFiles)

        print_top_frequencies(total_frequencies)

    except Exception as e:
        print(f"Error durante la fusión: {e}")
        sys.exit(1)

