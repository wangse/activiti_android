#/bin/bash

echo "Enter activiti.servebeer.com ssh username: "
read NAME
echo "Fetching credentials"
scp "$NAME"@activiti.servebeer.com:/home/central/credentials.tar.gz ./ &>/dev/null
echo "Extracting credentials"
tar xvf credentials.tar.gz &>/dev/null
mv connection.json $PWD/node_modules/database/
echo "Removing package"
rm -f credentials.tar.gz
echo "Update complete!"
