#!/bin/bash
# Verwendung: ./gradlew dependencyUpdates | grep '\->' | ./update_versions.sh

# Lies die Eingabe aus der Pipe ein
while IFS= read -r line; do
    # Extrahiere die Versionsnummern
    lib_name=$(echo "$line" | cut -d ' ' -f 3)
    old_version=$(echo "$line" | cut -d '[' -f 2 | sed 's/]//' | cut -d ' ' -f 1)
    new_version=$(echo "$line" | cut -d '[' -f 2 | sed 's/]//' | cut -d ' ' -f 3)

    repl_from="$lib_name:$old_version"
    repl_to="$lib_name:$new_version"

    # Falls eine der Variablen leer ist, überspringe die Zeile
    if [[ -z "$old_version" || -z "$new_version" ]]; then
        continue
    fi

    echo "Ersetze Version $old_version von $lib_name mit $new_version in allen build.gradle.kts Dateien..."

    # Finde alle build.gradle.kts Dateien und ersetze die alte Versionsnummer durch die neue
    # find . -name "build.gradle.kts" -exec sed -i "s/$old_version/$new_version/g" {} +
    find . -name "build.gradle.kts" -exec sed -i "s/$repl_from/$repl_to/g" {} +
done
